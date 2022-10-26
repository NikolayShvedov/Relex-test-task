# Relex-test-task

Тестовое задание по осенней стажировке от компании РЕЛЭКС.

RESTfull API service для обработки последовательности чисел.
  
Программа должна позволят считать массив целых чисел из текстового файла, обработать и выдать необходимые результаты. Результаты запрашиваются по средством REST-запросов, информация о файле передается в виде json (например):  
{  
	"file_path": "C:/test_data/10m.txt"  
}  
  
Числа в файле разделены между собой с помощью специального символа "\n" (каждое число на новой строке). 
В сервисе необходимо реализовать следующие операции (REST-запросы), возвращающие:
1.	максимальное число в файле;
2.	минимальное число в файле;
3.	медиана;
4.	среднее арифметическое значение;
5.	самая длинная последовательность идущих подряд чисел, которая увеличивается;
6.	самая длинная последовательность идущих подряд чисел, которая уменьшается.


Тип запрашиваемой операции может передаваться как параметр в json ("operation": "get_max_value"), так и определяться из URL запроса (http://../get_max_value)

Результат выдается так же в виде json (пример):  
{  
	"max_value": "777777"  
}  
  
# Cтек проекта
SpringBoot  
Java 11  
Swagger   
Docker  

# API requests  
1) Get maximum value in file:  
JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_max_value -d '{"path_file":"C:/test_data/10m.txt"}'`  
XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_max_value -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'`  
Response: `{"max_value":49999978}`  
  
2) Get minimum value in file:  
JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_min_value -d '{"path_file":"C:/test_data/10m.txt"}'`  
XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_min_value -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'`  
Response: `{"min_value":-49999996}`
  
3) Get median:  
JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_median -d '{"path_file":"C:/test_data/10m.txt"}'`  
XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_median -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'`  
Response: `{"median":25216.0}`  
  
4) Get Arithmetic mean:  
JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_arithmetic_mean -d '{"path_file":"C:/test_data/10m.txt"}'`  
XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_arithmetic_mean -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'`  
Response: `{"arithmetic_mean":7364.0}`

5) Get longest sequence of consecutive numbers that increases: 
JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_max_asc_sequence -d '{"path_file":"C:/test_data/10m.txt"}'`  
XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_max_asc_sequence -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'`  
Response: `{"sequences_ASC":{"1":[-48190694,-47725447,-43038241,-20190291,-17190728,-6172572,8475960,25205909,48332507,48676185]}}`

6) Get longest sequence of consecutive numbers that decreases:
JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_max_desc_sequence -d '{"path_file":"C:/test_data/10m.txt"}'`  
XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_max_desc_sequence -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'`  
Response: `{"sequences_DESC":{"1":[47689379,42381213,30043880,12102356,-4774057,-5157723,-11217378,-23005285,-23016933,-39209115,-49148762]}}`

7) Get requested operation: 
- get_max_value:  
  JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_max_value"}'`  
  XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_max_value</operation></data>'`  
  Response: `{"max_value":49999978}`
- get_min_value:  
  JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_min_value"}'`  
  XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_min_value</operation></data>'`  
  Response: `{"min_value":-49999996}`
- get_median:
  JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_median"}'`  
  XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_median</operation></data>'`  
  Response: `{"median":25216.0}`
- get_arithmetic_mean:
  JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_arithmetic_mean"}'`  
  XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_arithmetic_mean</operation></data>'`  
  Response: `{"arithmetic_mean":7364.0}`
- get_max_asc_sequence:
  JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_max_asc_sequence"}'`  
  XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_max_asc_sequence</operation></data>'`  
  Response: `{"sequences_ASC":{"1":[-48190694,-47725447,-43038241,-20190291,-17190728,-6172572,8475960,25205909,48332507,48676185]}}` 
- get_max_desc_sequence:
  JSON type: `curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_max_desc_sequence"}'`  
  XML type: `curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_max_desc_sequence</operation></data>'`  
  Response: `{"sequences_DESC":{"1":[47689379,42381213,30043880,12102356,-4774057,-5157723,-11217378,-23005285,-23016933,-39209115,-49148762]}}`  
  
  JSON type input, XML type output: `curl -H 'Content-Type: application/json' -H 'accept: application/xml' -s -XPOST http://localhost:8081/api/get_max_value -d '{"path_file":"C:/test_data/10m.txt"}'`  
  Response: `<?xml version="1.0" encoding="UTF-8" standalone="yes"?><data><max_value>4999997</max_value></data>`  
  XML type input, XML type output: `curl -H 'Content-Type: application/xml' -H 'accept: application/xml' -s -XPOST http://localhost:8081/api/get_max_value -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'`  
  Response: `<?xml version="1.0" encoding="UTF-8" standalone="yes"?><data><max_value>4999997</max_value></data>`
  XML type input, JSON type output: `curl -H 'Content-Type: application/xml' -H 'accept: application/json' -s -XPOST http://localhost:8081/api/get_max_value -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'`  
  Response: `{"max_value":49999978}`
  JSON type input, JSON type output:`curl -H 'Content-Type: application/json' -H 'accept: application/json' -s -XPOST http://localhost:8081/api/get_max_value -d '{"path_file":"C:/test_data/10m.txt"}'`  
  Response: `{"max_value":49999978}`  
Таким образом:  
1) максимальное число = 49999978  
2) минимальное число = -49999996  
3) медиана = 25216.0  
4) среднее арифметическое значение = 7364.0  
5) самая длинная последовательность идущих подряд чисел, которая увеличивается = [-48190694,-47725447,-43038241,-20190291,-17190728,-6172572,8475960,25205909,48332507,48676185]  
6) самая длинная последовательность идущих подряд чисел, которая уменьшается = [47689379,42381213,30043880,12102356,-4774057,-5157723,-11217378,-23005285,-23016933,-39209115,-49148762]  

# Docker  
Build gradle:  
`gradlew clean build`  
Build project image with docker:  
`docker image build ./ -t relex-image`  
Running the docker container container with an images:   
`docker run -p 8081:8081 -d --name relex-service relex-image`  
Stopping a docker container:  
`docker stop relex-service`
  
# Swagger
Для того, чтобы посмотреть все доступные пути энд-поинтов и их модели данных, на сервере подключен Swagger.
Чтобы увидеть страницу документации, нужно запустить сервер и перейти по пути `http://localhost:8081/swagger-ui.html#`
