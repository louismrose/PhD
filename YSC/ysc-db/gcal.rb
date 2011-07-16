require 'database.rb'
require 'film.rb'

require 'highline/import' 
require 'googlecalendar'

gcal = GData.new
gcal.login('louismrose@gmail.com', ask("Enter password for louismrose@gmail.com: ") { |q| q.echo = false })

Database.session do
  Film.after(Date.new(2008, 4, 1)).each do |f|
    puts "[INFO] Creating event for #{f.screen_date.to_s} - #{f.name}"
    
    event = { :title     => f.name,
              :content   => f.synopsis,
              :author    => 'Louis Rose',
              :email     => 'louismrose@gmail.com', 
              :where     => 'P/X/001, YO10',
              :startTime => "#{f.screen_date.to_s}T18:45:00.000Z",
              :endTime   => "#{f.screen_date.to_s}T22:00:00.000Z"}
      
    gcal.new_event(event, 'YSC 2008')
  end 
end
