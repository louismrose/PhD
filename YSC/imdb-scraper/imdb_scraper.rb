require 'rubygems'
require 'mechanize'
require 'cgi'

class Nokogiri::XML::Element
  def next_siblings
    next_siblings = []
    current = self.next_sibling
    
    while (current)
      next_siblings << current
      current = current.next_sibling
    end
    
    return next_siblings
  end
end

class ImdbScraper

  def scrape(page, film)
    @page = page

    film.director    = get_director
    film.starring    = get_cast.first(3)
    film.runtime     = get_runtime
    film.country     = scrape_first_link('Country:')
    film.certificate = get_certificate
    film.year        = get_year

    film
  end

private

  def get_director
    director_key = has_key('Director:') ? 'Director:' : 'Directors:'
    
    scrape_first_link(director_key) 
  end

  def get_cast
    @page.search("table.cast td.nm a").collect{|a| CGI.unescapeHTML a.content}
  end

  def get_runtime
    value = scrape_text('Runtime:')
    
    value ? value.sub('min', '').strip : nil
  end
  
  def get_certificate
    uk_certification_link = scrape_links('Certification:').select{|c| c.content.include? 'UK:'}.first
    uk_certification_link ? uk_certification_link.content.sub('UK:', '').strip : nil
  end

  def get_year
    # Most films have a title like: The Title (2008)
    # But some have a suffix in the year, eg: Twilight (2008/I), or Ghost Town (2008/II)

    # Define regular expressions
    four_digits_followed_by_optional_slash_and_chars_in_parentheses = '\((\d{4})(/[A-z]*)?\)$'

    @page.title.match(four_digits_followed_by_optional_slash_and_chars_in_parentheses)[1]
  end
  
  def scrape_first_link(imdb_key)
    scrape_links(imdb_key).first.content.strip
  end
  
  def scrape_links(imdb_key)
    scrape_value(imdb_key).search('a')
  end
  
  def scrape_text(imdb_key)
    scrape_value(imdb_key).content.strip
  end
  
  def scrape_value(imdb_key)
    # Presently, much of a film's details are presented as key-value pairs on IMDB
    # For example:
    #   Runtime:  94 min
    #   Certification: USA:R | UK:15
    #
    # This method returns the HTML element containing the value for the key, imdb_key
    
    key = keys.find{|tags| tags.content == imdb_key}
    
    # Presently on IMDB, there is a whitespace element between a key and its value
    key.next_sibling.next_sibling
  end
  
  def has_key(imdb_key)
    keys.any?{|key| key.content == imdb_key}
  end
  
  def keys
    @page.search("h5")
  end
end




