
import SwiftUI
import ComposableArchitecture

struct ContentView: View {
    var goToSecondView: (String) -> Void
    
    let viewModel: StoreOf<ContentFeature> = Store(
        initialState: ContentFeature.State(
            name: "Qvik",
            isLoading: false)
    ) {
            ContentFeature()
    }
    
    var body: some View {
        let state = viewModel.state
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, \(state.name)!")
            if state.isLoading {
                ProgressView()
            } else {
                Button("Button", action: {
                    viewModel.send(.getNewNameTapped)
                })
            }
            
            Button("Go to second view") {
                goToSecondView(state.name)
            }
        }
        .padding()
    }
}




#Preview {
    ContentView(goToSecondView: {_ in})
}
