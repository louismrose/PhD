describe "abbreviate" do
  context "for a single author" do
    it "should abbreviate a simple name" do
      abbreviate("Martin Fowler").should == "Fowler, M."
    end
    
    it "should abbreviate a name with a middle initial" do
      abbreviate("Richard F. Paige").should == "Paige, R.F."
    end
    
    it "should treat a name containing 'and' as a single name" do
      abbreviate("Yolande Berbers").should == "Berbers, Y."
    end
  end
  
  context "for two authors" do
    it "should abbreviate each name" do
      abbreviate("Shane Sendall and Wojtek Kozaczynski").should == "Sendall, S. and Kozaczynski, W."
    end
    
    it "should abbreviate each name when separated with newlines" do
      abbreviate("Shane Sendall and\nWojtek Kozaczynski").should == "Sendall, S. and Kozaczynski, W."
    end
  end
end

def abbreviate authors
  names = authors.split(/\s+and\s+/)
  abbreviated_names = names.map { |name| abbreviate_one(name) }
  abbreviated_names.join " and "
end

def abbreviate_one author
  name = Name.new author
  "#{name.surname}, #{name.initials}"
end

class Name
  def initialize(name)
    @parts = name.split
  end
  
  def surname
    @parts.last
  end
  
  def initials
    given_names.map { |n| initial_of n }.join
  end
  
private
  def given_names
    @parts[0, @parts.length-1]
  end
  
  def initial_of name
    name[0,1] + '.'
  end
end