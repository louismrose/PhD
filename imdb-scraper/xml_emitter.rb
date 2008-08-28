require 'rubygems'
require 'builder'

require 'film.rb'

class XmlEmitter

  def emit(data)
    if data.is_a?(Array)
      emit_films data
    
    elsif data.is_a?(Film)
      # Coerce to array
      emit_films [data]

    else
      raise 'Error: Unable to emit objects of type: ' + data.class
    end
  end

  def emit_error(code, message)
    xml = emit_result do
      @builder.ysc :error do
        @builder.ysc :code,    code
        @builder.ysc :message, message
      end
    end

   puts xml
  end

private

  def emit_films(films)
    xml = emit_result do
      films.each { |film| build_film film }
    end

    # Ruby symbols cannot contain dashes
    # So must perform String substitution on generated XML
    xml.gsub!('<ysc:imdb', '<ysc:imdb-id')
    xml.gsub!('<ysc:year', '<ysc:year-of-release')

    puts xml
  end

  def emit_result
    @builder = Builder::XmlMarkup.new :indent => 2
    @builder.instruct! :xml, :version => "1.0" 

    schema_info = {
                    "xmlns:xsi"          => "http://www.w3.org/2001/XMLSchema-instance",
                    "xmlns:ysc"          => "http://www.yorkstudentcinema.org/imdb",
                    "xsi:schemaLocation" => "http://www.yorkstudentcinema.org/imdb FilmInformation.xsd"
                  }

    @builder.ysc(:Result, schema_info) {yield}
  end

  def build_film(film)
    @builder.ysc :film do
      @builder.ysc :imdb,        film.imdb_id      if film.imdb_id
      @builder.ysc :title,       film.title        if film.title
      @builder.ysc :year,        film.year         if film.year
      @builder.ysc :runtime,     film.runtime      if film.runtime
      @builder.ysc :certificate, film.certificate  if film.certificate
      @builder.ysc :country,     film.country      if film.country
      @builder.ysc :director,    film.director     if film.director

      if film.starring
        @builder.ysc :starring do
          film.starring.each {|star| @builder.ysc :star, star}
        end
      end # if
    end # film tag
  end # method

end
