# Load necessary library
library(ggplot2)

# Read data from CSV file
data <- read.csv("employee_data.csv")

# Display the data frame
print(data)

# Create a bar plot of salary by name
png("salary_by_name.png", width = 800, height = 600)
barplot(data$salary, names.arg = data$name, main = "Salary by Name", xlab = "Name", ylab = "Salary", col = "skyblue")
dev.off()

# Create a bar plot of average salary by city
city_salary <- aggregate(salary ~ city, data, mean)
png("avg_salary_by_city.png", width = 800, height = 600)
barplot(city_salary$salary, names.arg = city_salary$city, main = "Average Salary by City", xlab = "City", ylab = "Average Salary", col = "lightgreen")
dev.off()