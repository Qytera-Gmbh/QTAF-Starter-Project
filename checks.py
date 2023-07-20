import os
import shutil
from datetime import date
import re

today = date.today()
date = today.strftime("%Y-%m-%d")

# Check that the log directories were created
assert os.path.exists("allure-results"), "There should be a directory named 'allure-results'"
assert os.path.exists("logs"), "There should be a directory named 'logs'"


logs_dir = "logs/" + os.listdir("logs")[0]
logs_dir += "/" + os.listdir(logs_dir)[0]
re_date = re.compile(date)

# Check that the log directory was created
assert re_date.search(logs_dir) is not None, "The log directory should contain the current date, but was '" + logs_dir + "'"

# Check that the HTML report was created
assert os.path.exists(logs_dir + "/Report.html"), "There should be a file named Report.html"

# Check that the JSON log file was created
assert os.path.exists(logs_dir + "/Report.json"), "There should be a file named Report.json"

log_files = os.listdir(logs_dir)
print(log_files)
log4j_files = list(filter(lambda x: x[0:11] == "application" and x[-4:] == ".log", os.listdir('.')))

# Check if all log files were created
n_html_files_expected, n_html_files = 8, len(list(filter(lambda x: x[-4:] == "html", log_files)))
n_json_files_expected, n_json_files = 1, len(list(filter(lambda x: x[-4:] == "json", log_files)))
n_png_files_expected, n_png_files = 22, len(list(filter(lambda x: x[-3:] == "png", log_files)))
n_log4j_files_expected, n_log4j_files = 1, len(log4j_files)
assert n_html_files == n_html_files_expected, f"There should be {n_html_files_expected} HTML file(s) in the log directory, but there were {n_html_files}"
assert n_json_files == n_json_files_expected, f"There should be {n_json_files_expected} JSON file(s) in the log directory, but there were {n_json_files}"
assert n_png_files == n_png_files_expected, f"There should be {n_png_files_expected} PNG file(s) in the log directory, but there were {n_png_files}"
assert n_log4j_files == n_log4j_files_expected, f"There should be {n_log4j_files_expected} log4j log file(s), but there were {n_log4j_files}"

# Clean directories
shutil.rmtree("allure-results")
shutil.rmtree("logs")
shutil.rmtree("target")

for f in log4j_files:
    os.remove(f)

try:
    shutil.rmtree("test-output")
except:
    None

print("All tests passed")
