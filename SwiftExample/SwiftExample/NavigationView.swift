//
//  NavigationView.swift
//  SwiftExample
//
//  Created by Matias Hätönen on 6.5.2024.
//

import SwiftUI

struct NavigationView: View {
    @State var navigationPath = NavigationPath()
    
    var body: some View {
        NavigationStack(path: $navigationPath) {
            ContentView { name in
                navigationPath.append(SecondViewDestination(name: name))
            }
            .navigationDestination(
                for: SecondViewDestination.self) { destination in
                    SecondView(name: destination.name) {
                        navigationPath.removeLast()
                    }
            }
        }
    }
}

struct SecondViewDestination: Hashable {
    var name: String
}
