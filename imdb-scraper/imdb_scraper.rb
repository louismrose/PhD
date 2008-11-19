require 'rubygems'
require 'mechanize'
require 'cgi'

# Add methods to the Hpricot Elem class
class Hpricot::Elem
  def next_siblings
    siblings_at(1, 1..parent.containers.size)
  end
end

class ImdbScraper

  def scrape(page, film)
    @page = page

    film.director    = get_value_near('Director:')
    film.starring    = get_cast.first(3)
    film.runtime     = get_runtime
    film.country     = get_value_near('Country:')
    film.certificate = get_certificate
    film.year        = get_year

    film
  end

private

  def get_cast
    @page.search("//table.cast//td.nm/a").collect{|a| CGI.unescapeHTML a.inner_html}
  end

  def get_runtime
    value = get_value_near('Runtime:')
    
    value ? value.sub('min', '').strip : nil
  end

  def get_certificate
    value = get_value_near('Certification:')

    return nil unless value

    uk_certification = value.select{|c| c.include? 'UK:'}.first
    uk_certification ? uk_certification.sub('UK:', '') : nil
  end

  def get_year
    # Most films have a title like: The Title (2008)
    # But some have a suffix in the year, eg: Twilight (2008/I), or Ghost Town (2008/II)

    # Define regular expressions
    four_digits_followed_by_optional_slash_and_chars_in_parentheses = '\((\d{4})(/[A-z]*)?\)$'

    @page.title.match(four_digits_followed_by_optional_slash_and_chars_in_parentheses)[1]
  end

  def get_value_near(text)
    element = @page.search("//h5").select{|tags| tags.inner_html == text}.first

    return nil unless element

    if (element.next_sibling)
      values = element.next_siblings.collect{|s| CGI.unescapeHTML s.inner_html.strip}
      values = values.compact.select{|s| s.size > 0}
      values.size == 1 ? values.first : values

    else
      # Remove this element from the inner text of the parent
      CGI.unescapeHTML element.parent.inner_text.sub(element.inner_text, '').strip
    end
  end
end




