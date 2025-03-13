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
