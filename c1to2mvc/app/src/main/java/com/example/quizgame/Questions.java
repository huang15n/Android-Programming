package com.example.quizgame;

public class Questions {
    private int questionResId;
    private boolean resultTrueOrFalse;

    public Questions(int questionResId, boolean resultTrueOrFalse){
        this.questionResId = questionResId;
        this.resultTrueOrFalse = resultTrueOrFalse;

    }

    public int getQuestionResId() {
        return questionResId;
    }

    public void setQuestionResId(int questionResId) {
        this.questionResId = questionResId;
    }

    public boolean isResultTrueOrFalse() {
        return resultTrueOrFalse;
    }

    public void setResultTrueOrFalse(boolean resultTrueOrFalse) {
        this.resultTrueOrFalse = resultTrueOrFalse;
    }
}
