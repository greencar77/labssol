import requests
from requests.auth import HTTPBasicAuth

JIRA_DOMAIN = "aaa.bbb.com"
EMAIL = "email@example.com"
API_TOKEN = "your_api_token"

url = f"https://{JIRA_DOMAIN}/rest/api/2/search"

# auth = HTTPBasicAuth(EMAIL, API_TOKEN)

print("Enter password:")
pwd = input()
from requests.auth import HTTPBasicAuth
auth = HTTPBasicAuth('usernamex', pwd)

headers = {
    "Accept": "application/json",
    "Content-Type": "application/json"
}

jql_query = 'project = SOMEPROJ ORDER BY key DESC, priority DESC, updated DESC'

start_at = 0
max_results = 50
total = 1

all_issues = []

limit = 20

while start_at < total:
    payload = {
        "jql": jql_query,
        "startAt": start_at,
        "maxResults": max_results,
        "fields": ["summary", "status", "assignee"]
    }

    response = requests.post(url, json=payload, headers=headers, auth=auth)
    response.raise_for_status()

    data = response.json()

    total = data["total"]
    issues = data["issues"]

    all_issues.extend(issues)
    start_at += max_results

    print("fetched ", len(issues), " issues")
    limit -= len(issues)
    if limit <= 0:
        break

print(f"Retrieved {len(all_issues)} issues")

for issue in all_issues:
    print(issue["key"], issue["fields"]["assignee"]["name"] if issue["fields"]["assignee"] else "Unassigned", issue["fields"]["status"]["name"], issue["fields"]["summary"])