<?php
	// The namespace of the YSC IMDB schema
	$ysc_ns_uri = 'http://www.yorkstudentcinema.org/imdb';

	// The prefix used for the namespace
	$ysc_prefix = 'ysc';

	
	// The title of the film to query
	//$film     = "Batman";
	//$film     = "Superman Returns";
	//$film     = "Erroneous title";
	$film = $_POST['film'];
	


	// Execute the Ruby script, storing the result in $lines
	$s="./driver.sh '" . $film . "' 2> debug2.txt";
	exec($s, $lines);

	// Join the $lines array, making the String, $xml_result
	$xml_result = implode("", $lines);

	// Construct a new SimpleXML object from the XML produced by the Ruby script
	// We need to pass the URI for the YSC namespace as the last argument
	$xml = new SimpleXMLElement($xml_result, NULL, FALSE, $ysc_ns_uri);


	// If the XML doesn't contain a film tag, an error has occurred
	if (empty($xml->film)) {
		echo "Error:" . "<br/>\n";

		echo $xml->error->code   . "<br/>\n";
		echo $xml->error->message . "<br/>\n";

	// Otherwise print the result of the query
	} else {
		
		// If there is only one answer, the query was unambiguous
		if (count($xml->children('ysc', TRUE)) == 1) {	
			echo "Definitive answer:" . "<br/>\n";

			echo $xml->film->{'imdb-id'}         . "<br/>\n";
			echo $xml->film->title               . "<br/>\n";
			echo $xml->film->{'year-of-release'} . "<br/>\n";
			echo $xml->film->runtime             . "<br/>\n";
			echo $xml->film->certificate         . "<br/>\n";
			echo $xml->film->country             . "<br/>\n";
			echo $xml->film->director            . "<br/>\n";

			foreach ($xml->film->starring->star as $star) {
				echo $star . "<br/>\n";
			}

		// Otherwise, the query was ambiguous
		} else {
			echo "Possible answers:" . "<br/>\n";
			
			foreach ($xml->film as $film) {
				echo $film->{'imdb-id'} . "<br/>\n";
				echo $film->title       . "<br/>\n";

				echo "<br/>\n";
			}
		}
	}
?>
