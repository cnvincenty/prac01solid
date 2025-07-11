#!/bin/bash
yum update -y
yum install -y java-17-amazon-corretto git

# Install Maven
cd /opt
wget https://archive.apache.org/dist/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz
tar xzf apache-maven-3.9.4-bin.tar.gz
ln -s apache-maven-3.9.4 maven
echo 'export PATH=/opt/maven/bin:$PATH' >> /etc/profile
source /etc/profile

# Create app user
useradd -m -s /bin/bash appuser

# Clone and build application
cd /home/appuser
git clone https://github.com/juanjosemirandam/prac01solid.git
cd prac01solid/partelogica

# Update application.properties with RDS connection
cat > src/main/resources/application.properties << EOF
spring.application.name=prac01solid

# MySQL Database (RDS)
spring.datasource.url=jdbc:mysql://${db_endpoint}/${db_name}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=${db_username}
spring.datasource.password=${db_password}

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Swagger/OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
EOF

# Build application
/opt/maven/bin/mvn clean package -DskipTests

# Create systemd service
cat > /etc/systemd/system/prac01solid.service << EOF
[Unit]
Description=Prac01Solid Spring Boot Application
After=network.target

[Service]
Type=simple
User=appuser
WorkingDirectory=/home/appuser/prac01solid/partelogica
ExecStart=/usr/bin/java -jar target/prac01solid-0.0.1-SNAPSHOT.jar
Restart=always
RestartSec=10

[Install]
WantedBy=multi-user.target
EOF

# Change ownership
chown -R appuser:appuser /home/appuser/prac01solid

# Start service
systemctl daemon-reload
systemctl enable prac01solid
systemctl start prac01solid