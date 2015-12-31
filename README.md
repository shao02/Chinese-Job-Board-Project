# Chinese-Job-Board-Project
Chinese Job Board

Call 1 - list all jobs:</br>
<b>http://localhost:8080/chinese_jobs_board/rest/loadList</b> <br>
[{"location":"NYC","id":"123","jobName":"餐馆厨师一名","datePost":"Dec 26 2015","contact":"Job1@gmail.com"},{"location":"NYC","id":"124","jobName":"急需家务员","datePost":"Dec 26 2015","contact":"Job2@gmail.com"},{"location":"NYC","id":"125","jobName":"家教若干","datePost":"Dec 26 2015","contact":"Job3@gmail.com"},{"location":"NYC","id":"126","jobName":"洗碗员","datePost":"Dec 26 2015","contact":"Job4@gmail.com"},{"location":"NYC","id":"121","jobName":"唐人街司机","datePost":"Dec 26 2015","contact":"Job5@gmail.com"}]

Call 2 - Get a Job post with id:</br>
<b>http://localhost:8080/chinese_jobs_board/rest/loadJob?id=???</b> <br>
{"location":"NYC","id":"123","details":"Job1 details","jobName":"餐馆厨师一名","datePost":"Dec 26 2015","contact":"Job1@gmail.com"}

Call 3 - Post a new Job:</br>
<b>http://localhost:8080/chinese_jobs_board/rest/job/postJob</b> <br>
curl -k -v -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' --data '{
"details": "急需家务员 123132",
"jobName": "急需家务员",
"datePost": "Dec 30 2015",
"contact": "mr lee",
"location": "918-394-2399"
}' http://localhost:8080/chinese_jobs_board/rest/job/postJob

Call 4 - Create user credential(User the response header for the postJob call):</br>
<b>http://localhost:8080/chinese_jobs_board/rest/createUser</b> <br>
curl -k -v -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' --data '{
"password": "lalee",
"userId": "laji"
}' http://localhost:8080/chinese_jobs_board/rest/createUser

Call 5 - Login Call:</br>
<b>http://localhost:8080/chinese_jobs_board/rest/isUser</b> <br>
curl -k -v -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' --data '{
"password": "lalee",
"userId": "laji"
}' http://localhost:8080/chinese_jobs_board/rest/isUser
