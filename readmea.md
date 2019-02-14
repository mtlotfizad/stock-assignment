# Stock

There are 4 REST end points:

1. GET /api/stocks returns list of all stocks. this end point can be controlled by paging parameters (page#, size, sorting column, sort strategy). Please find [the cUrl example](src/main/resources/cUrls/get-stock-list.sh) on project's repository.
2. GET /api/stocks/1 retrieve json of one stock (stock id#1) from database. Returns 404 if the stock can't be found.
3. PUT /api/stocks/1 update price of the referred stock.  Returns 404 if the stock can't be found.
4. POST /api/stocks creates new stock. A json body should be provided tho this end point with form of '{name, price}'. Please find [the cUrl example](src/main/resources/cUrls/new-stock.sh) on project's repository.

