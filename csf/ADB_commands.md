ADB Commands: Basic to Advanced

Basic ADB Commands

Check ADB Version:
adb version

List Connected Devices:
adb devices

Start ADB Server:
adb start-server

Stop ADB Server:
adb kill-server

Connect to a Device via IP:
adb tcpip 5555
adb connect <device-ip>:5555

Reboot Device:
adb reboot

Reboot into Bootloader:
adb reboot bootloader

Check Device Log:
adb logcat

File Management Commands

Pull a File from Device: adb pull /sdcard/file.txt <local-path>

Push a File to Device: adb push <local-file-path> /sdcard/

List Files in a Directory: adb shell ls /sdcard/

Delete a File: adb shell rm /sdcard/file.txt

Advanced ADB Commands

Access Device Shell: adb shell

Install an APK: adb install <apk-path>

Uninstall an App: adb uninstall <package-name>

List Installed Packages: adb shell pm list packages

Grant Specific Permissions: adb shell pm grant <package-name> <permission>

Take a Screenshot: adb shell screencap /sdcard/screenshot.png adb pull /sdcard/screenshot.png <local-path>

Record Screen: adb shell screenrecord /sdcard/video.mp4 adb pull /sdcard/video.mp4 <local-path>

Monitor Network Activity: adb shell dumpsys netstats

Forensic and Security Testing Commands

Extract Android Logs for Forensics: adb logcat -d > logcat.txt

Dump System Information: adb shell dumpsys

Check Running Processes: adb shell ps

Capture Network Traffic: adb shell tcpdump -i any -s 0 -w /sdcard/capture.pcap adb pull /sdcard/capture.pcap <local-path>

Unlock the Device via ADB: adb shell input keyevent 82

Simulate Touch Events: adb shell input tap <x> <y>

Simulate Swipe Events: adb shell input swipe <x1> <y1> <x2> <y2>

Dump Device’s SQLite Database: adb shell "run-as <package-name> cat databases/<db-name>" > <local-file>

Advanced Debugging and Penetration Testing

Forward Ports for Debugging: adb forward

tcp:<local-port> tcp:<device-port>

Reverse Port Forwarding: adb reverse

tcp:<local-port>

tcp:<device-port>

Launch an Activity: adb shell am start -n <package-name>/<activity-name>

Backup Data: adb backup -apk -shared -all -f backup.ab

Restore Backup: adb restore backup.ab

Bypass Lock Screen: adb shell rm /data/system/gesture.key adb reboot
