# TestContacts
Test task ⬇️

Create a "Contacts" app for Android.

App has "People" and "Detailed Info" screens.
Screen "People" should contain:
Option menu to change view: list/grid 
The list cell has a height of 48dp. It contains avatar, status(online), name
A grid cell is 48x48dp. It contains avatar, status
Button "Simulate Changes" that significantly and randomly change the model (change account statuses, names, remove users, and add users).
After tapping on a cell, the app shows detailed info for the selected user.

Screen "Detailed Info" should contain:
Big avatar
Account status
Name
Email


Requirements:
- Use Gravatar for avatars.
- UI has to be responsible, so all requests have to be done in another thread.
- Correct behaviour for configuration changes.

Will be a plus:
- The animated transition between list/grid view - avatars should move to a new place.
- The animated transition between "People" and "Detailed Info" - the selected avatar should move to a new place.

Will be a huge plus:
- Write tests.
