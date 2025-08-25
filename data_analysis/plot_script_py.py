import pandas as pd
import matplotlib.pyplot as plt

# Read data from CSV file
data = pd.read_csv('employee_data.csv')

# Display the data frame
print(data)

# Create a bar plot of salary by name
plt.figure(figsize=(10, 6))
plt.bar(data['name'], data['salary'], color='skyblue')
plt.title('Salary by Name')
plt.xlabel('Name')
plt.ylabel('Salary')
plt.xticks(rotation=45)
plt.tight_layout()
plt.savefig('salary_by_name_py.png')
plt.close()

# Create a bar plot of average salary by city
city_salary = data.groupby('city')['salary'].mean().reset_index()
plt.figure(figsize=(10, 6))
plt.bar(city_salary['city'], city_salary['salary'], color='lightgreen')
plt.title('Average Salary by City')
plt.xlabel('City')
plt.ylabel('Average Salary')
plt.xticks(rotation=45)
plt.tight_layout()
plt.savefig('avg_salary_by_city_py.png')
plt.close()

print("Python plots generated successfully.")