docker-compose -f grid.ymal up --scale chrome=2 -d

BROWSER=chrome docker-compose up

docker-compose -f grid.ymal up --scale firefox=2 -d

BROWSER=firefox docker-compose up

docker-compose -f grid.ymal down

docker-compose down



