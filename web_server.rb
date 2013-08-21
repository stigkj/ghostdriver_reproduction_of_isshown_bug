#!/usr/bin/env ruby

require 'sinatra'

set :public_folder, 'public'
set :bind, '0.0.0.0'

get '/' do
  redirect '/index.html'
end
