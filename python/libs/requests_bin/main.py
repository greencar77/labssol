import requests

response = requests.get("https://httpbin.org/get", params={
    "name": "Alice",
    "age": 30
})

print("Status code:", response.status_code)
print("JSON response:")
print(response.json())