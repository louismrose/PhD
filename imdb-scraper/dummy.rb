require 'optparse'

class Options
  def self.parse(args)
    options = {}
  
    OptionParser.new do |opts|
      opts.banner = "Usage: example.rb [options]"
    
      opts.on("-i", "--[no-]interactive", "Run interactively") do |i|
        options[:interactive] = i
      end
      
      opts.on("-x", "--[no-]xml", "Return XML") do |x|
        options[:xml] = x
      end
      
      opts.on("-q", "--query QUERY", String, "The film title or IMDB identifier to search for") do |query|
        options[:query] = query
      end
      
      opts.on_tail("-h", "--help", "Show this message") do
        puts opts
        exit
      end
    end.parse!(args)
    
    return options
  end
end

options = Options.parse(ARGV)

unless options[:query]
  puts 'A film title (or IMDB identifier) must be specified.'
  exit
end


# Temporary warnings

unless options[:xml]
  puts 'Text output not yet supported.'
  exit
end

if options[:interactive]
  puts 'Interactive mode not yet supported.'
  exit
end


# Print XML

if options[:query] == 'tt0348150' or options[:query] == 'Superman Returns'
  # Unambiguous result
  puts '<?xml version="1.0" encoding="UTF-8"?>'
  puts '<ysc:Result xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ysc="http://www.yorkstudentcinema.org/imdb" xsi:schemaLocation="http://www.yorkstudentcinema.org/imdb FilmInformation.xsd ">'
  puts "  <ysc:film>"
  puts "    <ysc:imdb-id>tt0348150</ysc:imdb-id>"
  puts "    <ysc:title>Superman Returns</ysc:title>"
  puts "    <ysc:year-of-release>2006</ysc:year-of-release>"
  puts "    <ysc:runtime>154</ysc:runtime>"
  puts "    <ysc:certificate>12A</ysc:certificate>"
  puts "    <ysc:country>USA</ysc:country>"
  puts "    <ysc:director>Bryan Singer</ysc:director>"   
  puts "    <ysc:starring>"
  puts "      <ysc:star>Brandon Routh</ysc:star>"
  puts "      <ysc:star>Kate Bosworth</ysc:star>"
  puts "      <ysc:star>Kevin Spacey</ysc:star>"
  puts "    </ysc:starring>"
  puts "  </ysc:film>"
  puts "</ysc:Result>"

elsif options[:query] == 'Batman'
  # Ambiguous result
  puts '<?xml version="1.0" encoding="UTF-8"?>'
  puts '<ysc:Result xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ysc="http://www.yorkstudentcinema.org/imdb" xsi:schemaLocation="http://www.yorkstudentcinema.org/imdb FilmInformation.xsd ">'
  puts "  <ysc:film>"
  puts "    <ysc:imdb-id>tt0096895</ysc:imdb-id>"
  puts "    <ysc:title>Batman</ysc:title>"
  puts "  </ysc:film>"
  puts "  <ysc:film>"
  puts "    <ysc:imdb-id>tt0103776</ysc:imdb-id>"
  puts "    <ysc:title>Batman Returns</ysc:title>"
  puts "  </ysc:film>"
  puts "</ysc:Result>"

else
  # Unrecognised title
  puts '<?xml version="1.0" encoding="UTF-8"?>'
  puts '<ysc:Result xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ysc="http://www.yorkstudentcinema.org/imdb" xsi:schemaLocation="http://www.yorkstudentcinema.org/imdb FilmInformation.xsd ">'
  puts "  <ysc:error>"
  puts "    <ysc:code>01</ysc:code>"
  puts "    <ysc:message>The title \'#{options[:query]}\' was not found on IMDB.</ysc:message>"
  puts "  </ysc:error>"
  puts "</ysc:Result>"
end

