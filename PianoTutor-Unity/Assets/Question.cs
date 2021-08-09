using UnityEngine.UI;
using UnityEngine;

[System.Serializable]
public class Question
{
    public Sprite questionImage;
    public string answer;

    public Question(Sprite img, string answer)
    {
        this.questionImage = img;
        this.answer = answer;
    }
}
