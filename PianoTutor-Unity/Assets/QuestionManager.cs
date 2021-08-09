using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class QuestionManager : MonoBehaviour
{
    private GameManager gm;
    private Question currentQuestion;

    public Image questionImage;
    public InputField answer;
    public TextMeshProUGUI scoreCounter;

    // Start is called before the first frame update
    void Start()
    {
        gm = GameManager.getGameManager();
        nextPressed();
    }
    public void checkPressed()
    {
        if(answer.text == currentQuestion.answer)
        {
            // correct
            gm.score += 10;
            scoreCounter.text = gm.score+"";

            nextPressed();
        }
        else
        {
            //wrong

        }
    }
    public void nextPressed()
    {
        currentQuestion = gm.getRandomQuestion();
        questionImage.sprite = currentQuestion.questionImage;
    }
    public void exitPressed()
    {
        Application.Quit();
    }
}
