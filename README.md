Lecture2Go Plugins
==================

This software is based on the Liferay 6.2 http://www.liferay.com

Lecture2Go http://lecture2go.uni-hamburg.de is an open source platform for media management and distribution. Our goal is to support the free access to knowledge. This software solution is aimed at academic institutions and has to strengthen the blended learning. All Lecture2Go plugins are continuously being developed and improved. For more details please visit http://lecture2go-open-source.rrz.uni-hamburg.de 


Change Log
==============
Bug Fix and Feature Package [master-v.1-b5162] on Friday, June 14, 2019

- 1316 RM - Opening and closing of div elements in the video admin area works incorrectly.
- 1354 RM - Download file points to wrong location.
- 1366 RM - RSS creation aborts for data without open access videos.
- 1315 RM - Author field in the admin area remains red after saving the new entry.
- 1237 RM - Problems with the chapter functionality on edge browsers.
- 1295 RM - Videos and lecture series with special characters can not be found.
- 1299 RM - Videos and lecture series with the special character "&" are not highlighted after searching request. 
- 1348 RM - Download fall back for public videos refers to incorrect file location.
- 1341 RM - Searching for speakers does not return individual videos.
- 1346 RM - Chapters for audio files have broken pictures.
- 1358 RM - Chapter clicks do not jump to the video.
- 1357 RM - Search for Lecturers returns (empty) hits for closed-access videos.
- 996 RM  - Coding problems with feeds.
  - The AdminLectureSeriesManagement.generateRSSforAllLectureseriesWhithOpenaccessVideos () method should be run if all RSS feeds are to be regenerated.
- 1032 RM - Subtitles integration.
  - For an upgrade only follow the steps below:
  - A "captions" folder is introduced to store (via symlinks) the subtitles for the end-user;
  - Two entries need to be added to the properties file:
      - lecture2go.captions.web.root=${lecture2go.web.root}/captions
      - lecture2go.captions.system.path=${lecture2go.media.repository}/captions
- 1333 RM - Add CC-BY-SA (4.0) and more to selectable licenses
  - For an upgrade only follow the steps below: 
  - INSERT INTO LG_License (licenseId,fullName, shortIdentifier, url, schemeName, schemeUrl, selectable, description) VALUES (1,"USTOM LICENSE", "UNI-CUSTOM-LICENSE", "https://your-custom-license", NULL, NULL, 1, NULL);
  - INSERT INTO LG_License (licenseId,fullName, shortIdentifier, url, schemeName, schemeUrl, selectable, description) VALUES (2,"Creative Commons Attribution Non Commercial Share Alike 3.0", "CC-BY-NC-SA-3.0", "https://creativecommons.org/licenses/by-nc-sa/3.0/", "SPDX", "https://spdx.org/licenses/", 1, NULL);
  - UPDATE LG_Video SET licenseId = 1 WHERE videoId IN (SELECT videoId FROM LG_License_old WHERE l2go);
  - UPDATE LG_Video SET licenseId = 2 WHERE videoId IN (SELECT videoId FROM LG_License_old WHERE ccbyncsa);


Bug Fix and Feature Package [master-v.1-b5146] on Wednesday, February 20, 2019

- 1273 RM - List of recently uploaded open access videos not updated correctly
- 1152 RM - Generation of the video hit list incorrectly
- 1262 RM - Renewed password entry on video call after call via series link
- 1257 RM - Change creation date of videos subsequent
- 1270 RM - Search function integrated in the "authors" view
- 1211 RM - The L2G_video_lectureseries table is reorganized.


Bug Fix and Feature Package [master-v.1-b5122] on Tuesday, January 22, 2019

- 1150 RM - Saving of video meta data takes to long.
- 1258 RM - Embed code in Moodle does not work.
- 1269 RM - Chapter function: umlauts in timeline not utf8 encoded.
- 1268 RM - RTSP Stream references always to the uploaded MP4 version.
- 1238 RM - Incorrect statistics values in the system menu.
- 1233 RM - Video detail page can not be accessed.
- 1217 RM - Refactoring of getFullVideo method
- 1216 RM - Search function in the "User Roles" interface implemented.
- 1256 RM - Search function in the "My Videos" interface implemented.


Bug Fix Package [master-v.1-b5050] on Thursday, October 11, 2018

- 1167 RM - Term scheduler integration.
- 1214 RM - Sub institutions can not be deleted
- 1215 RM - Response time of the catalog page optimized.
- 1165 RM - Download speed for closed access videos optimized.
- 1188 RM - Preview image for short videos is not created.
- 1041 RM - Wrong statistics for closed access videos.


Bug Fix Package [master-v.1-b5005] on Friday, September 28, 2018

- 1125 RM - Hits after search request for lecture series ignore specific order defined by the admin.
- 1187 RM - Upload alert shows wrong upload size limit.
- 1131 RM - Link to the lecture series ignores the defined video list order.
- 1202 RM - Submenu does not work on touch screen systems with the chrome browser.
- 1185 RM - Incorrect number of videos is displayed on the catalogue site for lecture series.
 
