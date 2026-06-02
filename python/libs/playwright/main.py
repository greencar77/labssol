from playwright.sync_api import sync_playwright
import os

file_path = os.path.abspath("page.html")
url = f"file:///{file_path.replace('\\', '/')}"

with sync_playwright() as p:
    browser = p.chromium.launch(headless=False)
    page = browser.new_page()

    page.goto(url)

    page.screenshot(path="output/local.png")
    page.pdf(path="output/local.pdf")

    page.click("text=Click me")

    page.wait_for_timeout(2000)

    page.screenshot(path="output/after_click.png")
    page.pdf(path="output/after_click.pdf")

    browser.close()