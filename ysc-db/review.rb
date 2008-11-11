require 'active_record'
require 'active_support'

class Review < ActiveRecord::Base
  set_table_name 'Reviews'
  set_primary_key 'FilmID'

  belongs_to :film, :foreign_key => 'FilmID'

  alias_attribute :text,         :Review
  alias_attribute :reviewer,     :Reviewer
  alias_attribute :submitted_by, :SubmittedBy
  alias_attribute :version,      :Version
  
  def readonly?
    true
  end

  def plain_text
    Review.strip_html Review.remove_linebreaks(text)
  end

private

  def self.remove_linebreaks(str)
    str.gsub(/\r\n/, " ").gsub(/\n/, " ")
  end

  def self.strip_html(str)
    str.gsub(/\s*<\/p>\s*<p>\s*/, "\n\n").gsub(/<\/?[^>]*>/, "")
  end

end
