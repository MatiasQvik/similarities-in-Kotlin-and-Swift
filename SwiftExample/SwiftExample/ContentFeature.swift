//
//  ContentViewModel.swift
//  SwiftExample
//
//  Created by Matias Hätönen on 6.5.2024.
//

import Foundation
import ComposableArchitecture

@Reducer
struct ContentFeature {
    @Dependency(\.nameRepository)
    var nameRepository
    
    @ObservableState
    struct State {
        var name: String
        var isLoading: Bool
    }
    
    enum Action {
        case getNewNameTapped
        case newNameLoaded(name: String)
    }
    
    var body: some ReducerOf<Self> {
        Reduce { state, action in
            switch action {
            case .getNewNameTapped:
                state.isLoading = true
                return .run { send in
                    let name = try await nameRepository.getName()
                    await send(.newNameLoaded(name: name))
                    
                }
            case .newNameLoaded(let name):
                state.isLoading = false
                state.name = name
                return .none
            }
        }
    }
}



