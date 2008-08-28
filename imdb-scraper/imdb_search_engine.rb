require 'rubygems'
require 'mechanize'
require 'cgi'

require 'film.rb'
require 'imdb_scraper.rb'

# Search IMDB for a film
class ImdbSearchEngine

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
    
    # Without spoofing an alias, IMDB returns 403 forbidden
    @agent.user_agent_alias = 'Linux Mozilla'
    
    page = @agent.get('http://www.imdb.com')
    
    # Populate and submit the search form
    search_form = page.form('find')
    search_form.q = title
    
    interpret_result(title, @agent.submit(search_form))
  end
  
  def interpret_result(title, page)
    # The page's name is the last segment of the URI
    page_name = page.uri.to_s.split('/').last
    
    # Search returned a single result
    if page_name[0,2] == 'tt'
      
      @result = ImdbScraper.new.scrape page, Film.new(page_name, strip_year(page.title))
    
    # Zero, or multiple results
    elsif page_name[0,4] == 'find'
    
      paras = page.search("//p")
      
      titles_para = paras.select{|p| p.inner_html.downcase.include? 'popular titles'}.first
      
      if titles_para
        title_links = titles_para.search("//a").select {|link| link.search("//img").empty? }
        
        identifiers = title_links.collect {|l| l['href'].chop.split('/').last }
        titles      = title_links.collect {|l| CGI.unescapeHTML(l.inner_html + l.next.to_s).strip}
        
        if identifiers.size == 1
          # Multiple results, but only one film so scrape data for that film
          film_page = @agent.get('http://www.imdb.com/title/' + identifiers.first)
          @result = ImdbScraper.new.scrape film_page, Film.new(identifiers.first, strip_year(film_page.title))

        else
          @results = identifiers.zip(titles).collect {|f| Film.new(f[0], f[1])}
          @result  = @results.first
        end
      end
    
      # Unless the text 'no matches' occurs on the page, then a result was found
     # if page.search("//p").select{|p| p.inner_html.downcase.include? 'no matches' }.empty? then
     # end
     
    else
      raise 'Landed on unrecognised page: ' + page.uri.to_s
    end
  end

  def strip_year(title)
    # Define regular expressions
    four_digits_in_parentheses = '\(\d{4}\)'
    any_characters = '(.*)'

    title.match(any_characters + ' ' + four_digits_in_parentheses)[1]
  end
end
