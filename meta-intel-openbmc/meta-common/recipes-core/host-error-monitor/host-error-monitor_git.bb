LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7becf906c8f8d03c237bad13bc3dac53"
inherit meson pkgconfig systemd

PACKAGECONFIG ??= ""
PACKAGECONFIG[libpeci] = "-Dlibpeci=enabled,-Dlibpeci=disabled"
PACKAGECONFIG[crashdump] = "-Dcrashdump=enabled,-Dcrashdump=disabled"
PACKAGECONFIG[send-to-logger] = "-Dsend-to-logger=enabled,-Dsend-to-logger=disabled"

EXTRA_OEMESON += "-Dtests=disabled"

SRC_URI = "git://github.com/openbmc/host-error-monitor;branch=master;protocol=https"

DEPENDS = "boost sdbusplus libgpiod libpeci phosphor-dbus-interfaces"

PV = "0.1+git${SRCPV}"
SRCREV = "d57d04ffa316f3c1dcef475270c33f6cbcead63e"

S = "${WORKDIR}/git"

SYSTEMD_SERVICE:${PN} += "xyz.openbmc_project.HostErrorMonitor.service"
