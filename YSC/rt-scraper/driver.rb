# Add the current directory to the Ruby seach path
# Without this, the following require statements may fail
$: << File.expand_path(File.dirname(__FILE__))

require 'rt_search_engine.rb'

# Print output

search_engine = RottenTomatoesSearchEngine.new
scraper       = RottenTomatoesScraper.new

if search_engine.find ARGV[0]
  film = scraper.scrape(search_engine.result)
  
  # Emit LaTeX
  puts "\\subsection\{#{film.title} (#{film.year})\}"
  puts "Rotten tomatoes rating: #{film.rating}\\%"
  puts ''
  puts "\\paragraph\{Synopsis:\} #{film.synopsis}"
  puts ''
  puts ''
end
