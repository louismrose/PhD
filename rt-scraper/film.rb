class Film
  attr_accessor :rt_id, :title, :year, :rating, :synopsis

  def initialize(rt_id, title, year)
    @rt_id = rt_id
    @title = title
    @year  = year
  end

  def url
    "http://www.rottentomatoes.com#{rt_id}"
  end
end
