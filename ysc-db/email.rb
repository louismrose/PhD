require 'database.rb'
require 'film.rb'

class WeeklyAnnouncementGenerator
  def initialize
    Database.session do
      @films = Film.for_this_week
    end
  end

  def generate
    print_header 
  
    @films.each do |f|
      puts f.summary
      puts ""
      puts ""
    end

    print_footer
  end 

private
  
  def print_header
    puts "This week at York Student Cinema"
    puts ""
  
    @films.each {|f| puts f.heading }

    puts ""
    puts "http://www.yorkstudentcinema.org/schedule.php"
    puts ""
    puts "Unless stated otherwise, screenings are in P/X001, doors 6.45pm, showing starts 7.30pm. ROAR"
    puts ""
    puts ""
  end

  def print_footer
    puts "General Information:"
    puts ""
    puts "All films are screened in P/X001 (in the Physics Concourse) - approx max capacity is 300, so please arrive in good time to avoid disappointment.  Additional screenings for sold out performances are not usually possible.  All films are presented in 35mm - the auditorium is equipped for Dolby Digital sound."
    puts ""
    puts "Ticket Prices:"
    puts ""
    puts "Staff/Students: £3.00"
    puts ""
    puts "Published ticket prices may not apply to films not listed in Exposure magazine (special events, preview screenings etc.) Unless stated, screenings begin at 7.30pm prompt in P/X/001 - doors 6.45pm. ROAR."
  end
end


# Reopen Film and add some new methods
Film.class_eval do
  def heading
    "#{screen_day} (#{screen_date.day}/#{screen_date.month}): #{name}"
  end

  def summary
    "#{screen_day}: #{name}\n" +
    "\n" +
    "http://www.yorkstudentcinema.org/film.php?id=#{id}\n" +
    "\n" +
    "#{review.plain_text}\n"
  end
end

WeeklyAnnouncementGenerator.new.generate

