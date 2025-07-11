output "ec2_public_ip" {
  description = "Public IP of EC2 instance"
  value       = aws_instance.app.public_ip
}

output "rds_endpoint" {
  description = "RDS instance endpoint"
  value       = aws_db_instance.main.endpoint
}

output "application_url" {
  description = "Application URL"
  value       = "http://${aws_instance.app.public_ip}:8080"
}

output "swagger_url" {
  description = "Swagger UI URL"
  value       = "http://${aws_instance.app.public_ip}:8080/swagger-ui.html"
}