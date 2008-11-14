require 'rubygems'
#require 'net/ssh/gateway'

class Database
  
  def self.session
    self.connect
    yield
    self.disconnect
  end
  
  def self.connect
#    puts "[INFO] Connecting to Gateway"
  #  @gateway = Net::SSH::Gateway.new('mcclure.dreamhost.com', 'ysc_site', :password => "6Slevin8")
		
   # @port = @gateway.open("mysql.yorkstudentcinema.org", 3306)
    
    ActiveRecord::Base.establish_connection({
      :host     => 'mysql.yorkstudentcinema.org',
      :adapter  => 'mysql',
      :database => 'site2',
      :username => 'louis',
      :password => 'kleenex57',
    })
    
    #puts "[INFO] Connected to Database through Gateway"
  end
	
  def self.disconnect
    #puts "[INFO] Tearing down Gateway connections"
    #@gateway.close @port
    #@gateway.shutdown!
  end
end
