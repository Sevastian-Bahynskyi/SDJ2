package com.example.lesson8_ex3.view_model;


import com.example.lesson8_ex3.model.Model;

public class ViewModelFactory
{
    private ConvertViewModel convertViewModel;
    public ViewModelFactory(Model model){
        convertViewModel = new ConvertViewModel(model);
    }


    public ConvertViewModel getConvertViewModel()
    {
        return convertViewModel;
    }
}
