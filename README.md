# PianoTutor
A small Piano quiz app to learn reading sheetmusic and the corresponding keys ont he keyboard. The first attempt of this project was done with android studio, but since android studio wasnt that stable at this time I moved the project to unity and there exported the project to a android application.

the goal in this project was to learn something when traveling with the bus or train and to add new questions easily. The last point is done by inserting new images for questions to the Resources-Folder with a specific name-pattern. The Program then automatically reads in all images of this folder and tries to create quesions with it. This system is good enough for simple image-based questions. A more general solution would be to use json files. I did this in my MusicQuiz-App.

### Keypoints
- Questionmanagement
- Add new questions easily
- UI Layout

### Some Code examples
**Creation of Questions by loading the files of the resources-folder**
```c#
private void CreateQuestions()
{
    Object[] files = Resources.LoadAll("questions", typeof(Sprite));
    questions = new Question[files.Length];
    for (int i = 0; i < files.Length; i++)
    {
       Object obj = files[i];
       Sprite img = (Sprite)obj;
       string answer = obj.name.Substring(obj.name.IndexOf("_") + 1);
       Regex rgx = new Regex(@"\d+$");
       answer = rgx.Replace(answer, "");
       questions[i] = new Question(img, answer);
    }
}
```
