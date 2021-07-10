#Run Springboot application in Docker Container
**Create a simple springboot project**
	* Create a simple Springboot application exposing an endpoint
	* To Create a docker container
		- Create a file "Dockerfile" inside springboot application folder
		- Create following Docker script inside the file 
			```
			FROM adoptopenjdk:11-jre-hotspot
			RUN mkdir /opt/app
			COPY target/docker-app-0.0.1.jar /opt/app
			CMD ["java", "-jar", "/opt/app/docker-app-0.0.1.jar"]
			EXPOSE 8080
			```
	
		- This will download the adoptopenjdk:11 hotspot image from DockerHub
		- Create a folder in app in /opt
		- Copy the springboot jar from target folder to /opt/app 
		- Then execute the jar with command java -jar "jarfile"
		- Expose the port 8080 from the Docker, so that it can be accessed outside the docker 

##Docker commands
	* To build the docker container
		```
		docker build -t "appName" .
		```
	* To run the docker
		- ```
			docker run -it --rm "appName"
			```
			This will run the application in the same command prompt itseld
			Also this will not map any port from docker to outside
		- ```
			docker run -d -p 8081:8080 "appName"
			```
			This command will run the application in the background and command prompt will be available for further commands
			The above command will map the exposed port 8080 to localhost port 8081, so that localhost can access the endpoints inside port 8080
		- ```
			docker ps -a
			```
			This command will list all running process/container insider the docker environment
		-```
			docker stop "containerId"
			```
			This command stops the running container. "containerId" is the id listed when docker ps -a command
		-```
			docker start "containerId"
			```
			This command starts the stopped container
		- ```
			docker images ls -a
			```
			This command list all the images hosted in the docker environment
		-```
			docker rmi "imageId"
			```
			This command removes the docker image from the docker environement. "imageId" is the id refered when docker images ls -a command
		-```
			docker logs "containerId"
			```
			Display the logs of the application running inside the containerID
		
		