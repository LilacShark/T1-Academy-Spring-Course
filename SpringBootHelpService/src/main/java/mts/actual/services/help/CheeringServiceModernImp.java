package mts.actual.services.help;

// Иллюстарция инжекта прототайпа в синглтон.
// Синглтон абстрактный. Протопайп обычный. В конфиге прописывается реализация синглтона
// в виде получения прототайпа из контекста по имени класса. Контекст создаст ноывй прототайп.

import mts.actual.services.help.config.SupaLogged;
import mts.actual.services.help.interfaces.CheeringService;
import mts.actual.services.help.model.CheeringPhrase;

@SupaLogged
public abstract class CheeringServiceModernImp implements CheeringService {

    public abstract CheeringPhrase getPhrase();

}
