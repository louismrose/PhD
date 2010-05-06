require 'active_support'
require 'active_record'

require 'review.rb'

class Film < ActiveRecord::Base
  set_table_name 'Film'
  set_primary_key 'ID'

  has_one :review, :foreign_key => 'FilmID'

  alias_attribute :name,             :Name
  alias_attribute :year,             :Year
  alias_attribute :publisher,        :Publisher
  alias_attribute :director,         :Director
  alias_attribute :country,          :Country
  alias_attribute :runtime,          :Runtime
  alias_attribute :certificate,      :Certificate
  alias_attribute :image,            :Image
  alias_attribute :front_page_image, :FrontPageImage
  alias_attribute :trailer,          :Trailer
  alias_attribute :synopsis,         :Synopsis
  alias_attribute :screen_date,      :ScreenDate
  alias_attribute :flags,            :Flags
  alias_attribute :audience,         :Audience
  
  def readonly?
    true
  end
  
  # Returns all films after the given date
  def self.after(date)
    raise "date must be a Date" unless date.kind_of? Date
    
    Film.find(:all, :conditions => "ScreenDate > '#{date}'", :order => "ScreenDate")
  end
 
  # Returns all films for a week after the given date
  def self.for_this_week
    self.for_week Date.yesterday
  end

  # Returns all films for a week after the given date
  def self.for_week(date)
    raise "date must be a Date" unless date.kind_of? Date
    
    Film.find(:all, :conditions => "ScreenDate > '#{date}' AND ScreenDate <= '#{date+7}'", :order => "ScreenDate")
  end
  
  # Returns the day of the screening (e.g. Monday)
  def screen_day
    Date::DAYNAMES[screen_date.wday]
  end
end
