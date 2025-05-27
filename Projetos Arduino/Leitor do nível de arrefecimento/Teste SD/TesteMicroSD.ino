#include "FS.h"
#include "SD.h"

#define SD_CS_PIN 13

void setup() {
  Serial.begin(115200);
  delay(2000);

  Serial.println("Iniciando SD...");

  if (!SD.begin(SD_CS_PIN)) {
    Serial.println("SD Card Mount Failed");
    return;
  }
  Serial.println("SD Card initialized.");

  File root = SD.open("/");
  File file = root.openNextFile();
  while (file) {
    Serial.print("File: ");
    Serial.println(file.name());
    file = root.openNextFile();
  }
}

void loop() {}