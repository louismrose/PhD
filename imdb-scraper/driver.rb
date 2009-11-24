require 'optparse'

# Add the current directory to the Ruby seach path
# Without this, the following require statements may fail
$: << File.expand_path(File.dirname(__FILE__))

require 'imdb_search_engine.rb'
require 'xml_emitter.rb'

class Options
  def self.parse(args)
    options = {}
  
    OptionParser.new do |opts|
      opts.banner = "Usage: driver.rb [options]"
    
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

search_engine = ImdbSearchEngine.new
emitter = XmlEmitter.new

if search_engine.find options[:query]
  if search_engine.unambiguous_result?
    emitter.emit search_engine.result
  else
    emitter.emit search_engine.results
  end

else
  emitter.emit_error "01", "The title \'#{options[:query]}\' was not found on IMDB."
end
