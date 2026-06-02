from playwright.sync_api import sync_playwright
import os

file_path = os.path.abspath("page_with_css.html")
url = f"file:///{file_path.replace('\\', '/')}"

with sync_playwright() as p:
    browser = p.chromium.launch()
    page = browser.new_page()

    page.goto(url)

    page.pdf(path="output/external.pdf", format="A4", print_background=True)

    browser.close()