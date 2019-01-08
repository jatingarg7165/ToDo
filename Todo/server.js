// var express = require('express');
// var app = express();
// app.all('/*', function(req, res, next) {
//   // CORS headers
//   res.header("Access-Control-Allow-Origin", "*"); // restrict it to the required domain
//   res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS');
//   // Set custom headers for CORS
//   res.header('Access-Control-Allow-Headers', 'Content-type,Accept,X-Access-Token,X-Key');
//   if (req.method == 'OPTIONS') {
//       res.status(200).end();
//   } else {
//       next();
//   }
// });
// var port = process.env.PORT || 4200;
// app.listen(port, '0.0.0.0');