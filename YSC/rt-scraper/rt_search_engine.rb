require 'rubygems'
require 'mechanize'
require 'cgi'

require 'film.rb'
require 'rt_scraper.rb'


# Reopen String class and add utility methods
String.class_eval do
  def starts_with?(prefix)
    prefix = prefix.to_s
    self[0, prefix.length] == prefix
  end
end


# Search RottenTomatoes for a film
class RottenTomatoesSearchEngine

  attr_reader :result, :results

  def find(title)
    @result, @results = nil
    
    do_search title
    
    not @result.nil?
  end
  
  def unambiguous_result?
    @results.nil?
  end
  
private
  
  def do_search(title)
    @agent = WWW::Mechanize.new
    
    page = @agent.get('http://www.rottentomatoes.com')
    
    # Populate and submit the search form
    search_form = page.form('searchformnew')
    search_form.search = title
    
    interpret_result(title, @agent.submit(search_form))
  end
  
  def interpret_result(title, page)
    # The page's name is the last segment of the URI
    page_name = page.uri.to_s.split('/').last
    
    # Search returned a zero or multiple results
    if page_name.starts_with?('full_search.php')
      
      # Find the results
      div = page.search("//div#search_results_main")

      # Grab the rows of the first table (movie results)
      rows = div.at("table").search("tr")

      # Determine the identifier, title and year of each result
      identifiers = rows.collect {|row| row.search('td').first.at('a')['href'] }
      titles      = rows.collect {|row| row.search('td').first.at('a').innerText }
      years       = rows.collect {|row| row.search('td').last.innerText }

      # Construct corresponding film objects
      @results = identifiers.zip(titles, years).collect {|f| Film.new(f[0], f[1], f[2])}
      @result  = @results.first   
    else
      raise 'Landed on unrecognised page: ' + page.uri.to_s
    end
  end
end
