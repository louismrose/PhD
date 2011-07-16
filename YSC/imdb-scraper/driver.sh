export GEM_PATH=/home/ysc_site/local-gems/.gems:/usr/lib/ruby/gems/1.8
ruby driver.rb -x -q "$1" 2> debug.txt
