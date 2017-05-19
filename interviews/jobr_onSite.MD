## Q1 how to parse to solve equations
assuming only =,+ are there, and it is alway solvable, 
in terms that there is no circule depency in the declaration of varable
*e.g.*
*a=c*
*b=3+a*
*c=1+d+b+a*
*d=5*

## Q2
###a, what will happen to your browser when you type 'google.com'
DNS, load balancer, more load balancer, CDN (content delivery network)
http protocal, or http**s**, check cache, blabla

###b, introduce the achitecture of smallrepo, what will do if the DB is slow
shard the data, build another DB including index for the shards
with to serve as a cache layer, do the distrubted hash for each shard
*lonnie said shard requires extra work to do, a easy and quick (temp?) fix is build a mirror (copy) of the DB*

##Q3, again introduce my smallrepo project, how the website is build, design for REST API:

data with name and ID
API needs: delete ID, add name, change name, print the list

REST is a very loose API, there are many different actions, not only DEL, PUT, GET and POST, as long as serve and client
has a plan, it is fine.
**Add**:
url: ..../users
action: POST
body {name}
return {bool: *exist or not*}
**change**:
url: ..../users:id231341
action: POST
body {name}
return {bool: *exist or not*}
**delete**:
url: ..../users:id12312
action: DEL
body {name}
return {bool: *exist or not*}
**print all**:
url: ..../users
action: GET
return {list}

##Q4, use golang http and Json package to decode and unmarshal a json file.