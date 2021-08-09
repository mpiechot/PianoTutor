using System.Collections;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    private Question[] questions;
    public int score;
    private static GameManager gm;

    // Start is called before the first frame update
    void Awake()
    {
        gm = this;

        CreateQuestions();
    }

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

    public static GameManager getGameManager()
    {
        return gm;
    }

    public Question getRandomQuestion()
    {
        return questions[Random.Range(0, questions.Length)];
    }
}
