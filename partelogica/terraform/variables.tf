variable "aws_region" {
  description = "AWS region"
  type        = string
  default     = "us-east-1"
}



variable "db_username" {
  description = "Database username"
  type        = string
  default     = "admin"
}

variable "db_password" {
  description = "Database password"
  type        = string
  sensitive   = true
}