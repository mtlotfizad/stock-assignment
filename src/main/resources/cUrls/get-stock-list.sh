curl -X GET \
  'http://localhost:8080/api/stocks?page=0&size=3&sort=currentPrice,DESC' \
  -H 'cache-control: no-cache'