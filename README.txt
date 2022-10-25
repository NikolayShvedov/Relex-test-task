# API requests
1) Get maximum value in file:  
JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_max_value -d '{"path_file":"C:/test_data/10m.txt"}'  
XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_max_value -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'  
Response: {"max_value":49999978}  
  
2) Get minimum value in file:  
JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_min_value -d '{"path_file":"C:/test_data/10m.txt"}'  
XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_min_value -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'  
Response: {"min_value":-49999996}
  
3) Get median:  
JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_median -d '{"path_file":"C:/test_data/10m.txt"}'  
XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_median -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'  
Response: {"median":25216.0}  
  
4) Get Arithmetic mean:  
JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_arithmetic_mean -d '{"path_file":"C:/test_data/10m.txt"}'  
XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_arithmetic_mean -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'  
Response: {"arithmetic_mean":7364.0}

5) Get longest sequence of consecutive numbers that increases: 
JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_max_asc_sequence -d '{"path_file":"C:/test_data/10m.txt"}'  
XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_max_asc_sequence -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'  
Response: {"sequences_ASC":{"1":[-48190694,-47725447,-43038241,-20190291,-17190728,-6172572,8475960,25205909,48332507,48676185]}}

6) Get longest sequence of consecutive numbers that decreases:
JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/get_max_desc_sequence -d '{"path_file":"C:/test_data/10m.txt"}'  
XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/get_max_desc_sequence -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>null</operation></data>'  
Response: {"sequences_DESC":{"1":[47689379,42381213,30043880,12102356,-4774057,-5157723,-11217378,-23005285,-23016933,-39209115,-49148762]}}

7) Get requested operation: 
- get_max_value:  
  JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_max_value"}'  
  XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_max_value</operation></data>'  
  Response: {"max_value":49999978}
- get_min_value:
  JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_min_value"}'  
  XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_min_value</operation></data>'  
  Response: {"min_value":-49999996}
- get_median:
  JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_median"}'  
  XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_median</operation></data>'  
  Response: {"median":25216.0}
- get_arithmetic_mean:
  JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_arithmetic_mean"}'  
  XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_arithmetic_mean</operation></data>'  
  Response: {"arithmetic_mean":7364.0}
- get_max_asc_sequence:
  JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_max_asc_sequence"}'  
  XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_max_asc_sequence</operation></data>'  
  Response: {"sequences_ASC":{"1":[-48190694,-47725447,-43038241,-20190291,-17190728,-6172572,8475960,25205909,48332507,48676185]}} 
- get_max_desc_sequence:
  JSON type: curl -H 'Content-Type: application/json' -s -XPOST http://localhost:8081/api/ -d '{"path_file":"C:/test_data/10m.txt","operation":"get_max_desc_sequence"}'  
  XML type: curl -H 'Content-Type: application/xml' -s -XPOST http://localhost:8081/api/ -d '<data><path_file>C:/test_data/10m.txt</path_file><operation>get_max_desc_sequence</operation></data>'  
  Response: {"sequences_DESC":{"1":[47689379,42381213,30043880,12102356,-4774057,-5157723,-11217378,-23005285,-23016933,-39209115,-49148762]}}  

Таким образом:  
1) максимальное число = 49999978  
2) минимальное число = -49999996  
3) медиана = 25216.0  
4) среднее арифметическое значение = 7364.0  
5) самая длинная последовательность идущих подряд чисел, которая увеличивается = [-48190694,-47725447,-43038241,-20190291,-17190728,-6172572,8475960,25205909,48332507,48676185]  
6) самая длинная последовательность идущих подряд чисел, которая уменьшается = [47689379,42381213,30043880,12102356,-4774057,-5157723,-11217378,-23005285,-23016933,-39209115,-49148762]  
Ссылка на видеозапись работы: https://drive.google.com/drive/folders/1rpwr3iuwlw_BRksmvMRhXNRYJI1rBvF_?usp=sharing

# Docker
Build gradle:  
	gradlew clean build  
Build project image with docker:  
	docker image build ./ -t relex-image  
Running the docker container container with an images:   
	docker run -p 8081:8081 -d --name relex-service relex-image  
Stopping a docker container:  
	docker stop relex-service
  
Swagger
http://localhost:8081/swagger-ui.html#
