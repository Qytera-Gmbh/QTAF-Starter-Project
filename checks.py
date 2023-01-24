import os
from datetime import date
import re

today = date.today()
date = today.strftime("%Y-%m-%d")

assert os.path.exists("allure-results"), "There should be a directory named 'allure-results'"
assert os.path.exists("logs"), "There should be a directory named 'logs'"

logs_dir = "logs/" + os.listdir("logs")[0]
logs_dir += "/" + os.listdir(logs_dir)[0]
re_date = re.compile(date)

assert re_date.search(logs_dir) is not None, "The log directory should contain the current date, but was '" + logs_dir + "'"
assert os.path.exists(logs_dir + "/Report.html"), "There should be a file named Report.html"
assert os.path.exists(logs_dir + "/Report.json"), "There should be a file named Report.json"

log_files = os.listdir(logs_dir)

assert len(list(filter(lambda x: x[-4:] == "html", log_files))) == 7, "There should be seven HTML files in the log directory"
assert len(list(filter(lambda x: x[-4:] == "json", log_files))) == 1, "There should be one JSON file in the log directory"
assert len(list(filter(lambda x: x[-3:] == "png", log_files))) == 14, "There should be 14 PNG files in the log directory"

print("All tests passed")