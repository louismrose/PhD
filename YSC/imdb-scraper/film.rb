class Film
  attr_accessor :imdb_id, :title, :director,
                :starring, :runtime, :country,
                :certificate, :year

  def initialize(imdb_id, title)
    @imdb_id = imdb_id
    @title   = title
  end
end
